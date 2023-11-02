package com.minatoorgtestcase.prodtest1.webservice.mapper;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Priority;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import com.eva.base.dal.CompositeFilter;
import com.eva.base.dal.Filter;
import com.eva.base.dal.SimpleFilter;
import com.eva.base.exception.InternalException;
import com.eva.base.logger.Logger;
import com.eva.base.logger.LoggerFactory;
import com.eva.base.util.DateUtil;
import com.eva.base.util.ErrorCode;
import com.eva.jersey.webservice.mapper.DatatablePaginationJsonMapper;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Priority(0)
public class CustomDataTablePaginationMapper extends DatatablePaginationJsonMapper {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomDataTablePaginationMapper.class);

	@Override
	public void parseFilter(Property properties, Map<String, Object> searchFilter) {
		if (searchFilter == null) {
			return;
		}
		Set<Entry<String, Object>> entrySet = searchFilter.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			String key = entry.getKey();
			Object value = entry.getValue();
			checkValueTypeAndAddFilter(properties, key, value);
		}
	}

	private void checkValueTypeAndAddFilter(Property properties, String key, Object value) {
		try {
			SimpleFilter startFilter = null;
			SimpleFilter endFilter = null;
			Long lLimit = null;
			Long uLimit = null;
			if (value instanceof Map) {
				Map<String, Object> range = (Map<String, Object>) value;
				if (null != range.get("lLimit")) {
					lLimit = ((Number) range.get("lLimit")).longValue();
				}
				if (null != range.get("uLimit")) {
					uLimit = ((Number) range.get("uLimit")).longValue();
				}
				if (range.get("type").equals("Date")) {
					if (lLimit != null) {
						startFilter = new SimpleFilter(key, DateUtil.getDateInISO8601Format(lLimit),
								Filter.Operator.GREATER_THAN_OR_EQUAL);
					}
					if (uLimit != null) {
						endFilter = new SimpleFilter(key, DateUtil.getDateInISO8601Format(uLimit),
								Filter.Operator.LESS_THAN_OR_EQUAL);
					}
				} else if (range.get("type").equals("Number")) {
					if (lLimit != null) {
						startFilter = new SimpleFilter(key, lLimit, Filter.Operator.GREATER_THAN_OR_EQUAL);
					}
					if (uLimit != null) {
						endFilter = new SimpleFilter(key, uLimit, Filter.Operator.LESS_THAN_OR_EQUAL);
					}
				}
				CompositeFilter cmpFilter = null;
				if (startFilter != null && endFilter != null) {
					cmpFilter = CompositeFilter.and().add(startFilter, endFilter);
				} else if (startFilter != null && endFilter == null) {
					cmpFilter = CompositeFilter.and().add(startFilter);
				} else if (endFilter != null) {
					cmpFilter = CompositeFilter.and().add(endFilter);
				}
				if (cmpFilter != null)
					properties.addFilter(key, cmpFilter);
			} else if (value instanceof List) {
				properties.addFilter(key, value, Filter.Operator.IN);
			} else {
				properties.addFilter(key, value);
			}
		} catch (Exception e) {
			LOGGER.error("Error while converting to filters", e);
			throw new InternalException(ErrorCode.ILLEGAL_ARGUMENT_EXCEPTION);
		}
	}
}
