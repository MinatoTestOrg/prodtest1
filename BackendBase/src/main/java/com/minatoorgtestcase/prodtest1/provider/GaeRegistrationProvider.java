package com.minatoorgtestcase.prodtest1.provider;

import java.util.HashMap;
import java.util.Map;

import com.eva.base.cache.CacheManager;
import com.eva.base.cache.TaskHandlerCache;
import com.eva.base.dal.providers.PersistenceType;
import com.eva.base.dal.providers.connection.ConnectionManager;
import com.eva.base.exception.BaseEvaException;
import com.eva.base.exception.InternalException;
import com.eva.base.logger.Logger;
import com.eva.base.logger.LoggerFactory;
import com.eva.base.provider.RegistrationProvider;
import com.eva.base.tasks.logic.ITaskHandlerCache;
import com.eva.base.tasks.logic.TaskManager;
import com.eva.base.thread.ThreadManager;
import com.eva.base.transaction.TransactionManager;
import com.eva.base.util.Constants;
import com.google.appengine.api.utils.SystemProperty;
import com.vs.eva.gaelibrary.cache.ProviderPropertiesCache;
import com.vs.eva.gaelibrary.provider.GaeProviderPropertiesBL;
import com.vs.eva.gaelibrary.queue.connection.QueueTransactionManager;
import com.vs.eva.gaelibrary.task.GaeTaskExecution;
import com.vs.eva.gaelibrary.thread.GaeThreadManager;
import com.vs.eva.gcplibrary.cache.SynchronizeCache;
import com.vs.eva.gcs.connection.GCSConnection;

/**
 * Registration provider for registering all the implementations specific to GAE
 * environment
 * 
 * @author ekarthik
 * @since 17-Sep-2019
 *
 */
public class GaeRegistrationProvider implements RegistrationProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(GaeRegistrationProvider.class);
	private static final Map<String, Object> providerProperties = new HashMap<>();

	/**
	 * Checks whether all the required registration are being registered, if
	 * registered through app, then uses that otherwise this method will register
	 * with the default implementation. The default implementation are registered
	 * for ThreadManager, SynchronizeCache, TaskHandlerCache, GCSFileStorage,
	 * QueueTransactionManager
	 */
	@Override
	public void configure() {
		try {
			// initialize ThreadManager for the GAE
			ThreadManager.getInstance();
		} catch (InternalException e) {
			LOGGER.debug("ThreaManager is not registered, so registering with default thread manager",
					e.getErrorCode());
			ThreadManager.initializeThreadManager(new GaeThreadManager());
		}
		// register synchronize cache
		if (CacheManager.getInstance().getCache(SynchronizeCache.NAME) == null) {
			CacheManager.getInstance().register(new SynchronizeCache());
			LOGGER.debug("Registering Synchronize cache");
		}
		// register Task Handlere cache
		if (CacheManager.getInstance().getCache(ITaskHandlerCache.NAME) == null) {
			CacheManager.getInstance().register(new TaskHandlerCache());
			LOGGER.debug("Registering Synchronize cache");
		}
		// register Provider properties cache
		/*if (CacheManager.getInstance().getCache(ProviderPropertiesCache.NAME) == null) {
			CacheManager.getInstance().register(new ProviderPropertiesCache());
			LOGGER.debug("Registering Provider properties cache");
		}*/
		try {
			ConnectionManager.getConnection(PersistenceType.FILES);
		} catch (BaseEvaException e) {
			LOGGER.debug("Registering default GCS Connection for storing files");
			ConnectionManager.register(PersistenceType.FILES, new GCSConnection(SystemProperty.applicationId.get()));
		}
		if (!TaskManager.hasExecution()) {
			TaskManager.register(new GaeTaskExecution());
			LOGGER.info("Registered GAE Task Execution Providers");
		}
		try {
			TransactionManager.getInstance().getTxnManager(PersistenceType.QUEUE);
		} catch (BaseEvaException e) {
			LOGGER.debug("Registering default Queue transaction manager");
			TransactionManager.register(PersistenceType.QUEUE, new QueueTransactionManager());
		}
		// GaeProviderPropertiesBL.setProviderProperties(loadProviederProperties(Constants.PROVIDER_PROPERTIES_FILE_NAME));
		LOGGER.info("Registered GAE Providers");
	}

	/**
	 * This method will be called during the shutdown of the instance, any specific
	 * implementation that needs to be done during the shutdown should be done here
	 */
	@Override
	public void release() {
		LOGGER.info("Registered GAE Providers");
	}
}
