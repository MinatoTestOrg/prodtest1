import { BsModalService, ModalOptions, BsModalRef } from 'ngx-bootstrap/modal';
import { UploaderService } from '@baseapp/upload-attachment.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { OnInit, Component } from '@angular/core';
import { ActionItem } from '@baseapp/widgets/action-bar/action-bar.component';
import { AppGlobalService } from '@baseapp/app-global.service';
import { AppConstants } from '@app/app-constants';
import { BreadcrumbService } from '@baseapp/widgets/breadcrumb/breadcrumb.service';
import { Table1Service } from '@baseapp/table1/table1/table1.service';
import { environment } from '@env/environment';
import { AppUtilBaseService } from '@baseapp/app-util.base.service';
import { ConfirmationPopupComponent } from '@baseapp/widgets/confirmation/confirmation-popup.component';
import { BaseAppConstants } from '@baseapp/app-constants.base';
import { debounceTime, fromEvent, catchError, combineLatest, distinctUntilChanged, of, Observer, Subscription, map, Observable, Subject } from 'rxjs';
import { allowedValuesValidator } from '@baseapp/widgets/validators/allowedValuesValidator';
import { ActivatedRoute, Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import { dateValidator } from '@baseapp/widgets/validators/dateValidator';
import { DialogService } from 'primeng/dynamicdialog';
import { ConfirmationService, MessageService } from 'primeng/api';
import { WorkflowSimulatorComponent } from '@baseapp/widgets/workflow-simulator/workflow-simulator.component';
import { Table1DetailBaseComponent } from '@baseapp/table1/table1/table1-detail/table1-detail.base.component';
import { TranslateService } from '@ngx-translate/core';
import { Location } from '@angular/common';
import { ChangeLogsComponent } from '@baseapp/widgets/change-logs/change-logs.component';
import { WorkflowHistoryComponent } from '@baseapp/widgets/workflow-history/workflow-history.component';
import { AppBaseService } from '@baseapp/app.base.service';


@Component({
  selector: 'app-table1-detail',
  templateUrl: '../../../../../base/app/table1/table1/table1-detail/table1-detail.component.html',
  styleUrls: ['./table1-detail.scss']
})
export class Table1DetailComponent extends Table1DetailBaseComponent implements OnInit {
 
  constructor(public override table1Service: Table1Service, public override appUtilBaseService: AppUtilBaseService, public override translateService: TranslateService, public override messageService: MessageService, public override confirmationService: ConfirmationService, public override dialogService: DialogService, public override domSanitizer: DomSanitizer, public override bsModalService: BsModalService, public override activatedRoute: ActivatedRoute, public override breadcrumbService: BreadcrumbService, public override appBaseService: AppBaseService, public override router: Router, public override appGlobalService: AppGlobalService, public override uploaderService: UploaderService, public override location: Location) {
    super(table1Service, appUtilBaseService, translateService, messageService, confirmationService, dialogService, domSanitizer, bsModalService, activatedRoute, breadcrumbService, appBaseService, router, appGlobalService, uploaderService, location);
  }
	
  ngAfterViewInit(): void {
    this.onAfterViewInit()
  }

  ngOnInit(): void {
    super.onInit();
  }
 
}