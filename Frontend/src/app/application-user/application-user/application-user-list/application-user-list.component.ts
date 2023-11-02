import { allowedValuesValidator } from '@baseapp/widgets/validators/allowedValuesValidator';
import { debounceTime, fromEvent, catchError, combineLatest, distinctUntilChanged, of, Observer, Subscription, map, Observable, Subject } from 'rxjs';
import { BsModalService, ModalOptions, BsModalRef } from 'ngx-bootstrap/modal';
import { ApplicationUserService } from '@baseapp/application-user/application-user/application-user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { OnInit, ElementRef, Renderer2, ViewChild, Component } from '@angular/core';
import { AppGlobalService } from '@baseapp/app-global.service';
import { GridComponent } from '@baseapp/widgets/grid/grid.component';
import { DomSanitizer } from '@angular/platform-browser';
import { DialogService } from 'primeng/dynamicdialog';
import { Filter } from '@baseapp/vs-models/filter.model';
import { AppConstants } from '@app/app-constants';
import { ConfirmationService, MessageService } from 'primeng/api';
import { ApplicationUserListBaseComponent } from '@baseapp/application-user/application-user/application-user-list/application-user-list.base.component';
import { TranslateService } from '@ngx-translate/core';
import { ChangeLogsComponent } from '@baseapp/widgets/change-logs/change-logs.component';
import { environment } from '@env/environment';
import { AppUtilBaseService } from '@baseapp/app-util.base.service';


@Component({
  selector: 'app-application-user-list',
  templateUrl: '../../../../../base/app/application-user/application-user/application-user-list/application-user-list.component.html',
  styleUrls: ['./application-user-list.scss']
})
export class ApplicationUserListComponent extends ApplicationUserListBaseComponent implements OnInit {
 
  constructor(public override applicationUserService: ApplicationUserService, public override appUtilBaseService: AppUtilBaseService, public override translateService: TranslateService, public override messageService: MessageService, public override confirmationService: ConfirmationService, public override dialogService: DialogService, public override domSanitizer: DomSanitizer, public override bsModalService: BsModalService, public override activatedRoute: ActivatedRoute, public override renderer2: Renderer2, public override router: Router, public override appGlobalService: AppGlobalService) {
    super(applicationUserService, appUtilBaseService, translateService, messageService, confirmationService, dialogService, domSanitizer, bsModalService, activatedRoute, renderer2, router, appGlobalService);
  }
	
  ngAfterViewInit(): void {
    this.onAfterViewInit()
  }

  ngOnInit(): void {
    super.onInit();
  }
 
}