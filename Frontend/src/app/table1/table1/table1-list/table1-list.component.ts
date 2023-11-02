import { allowedValuesValidator } from '@baseapp/widgets/validators/allowedValuesValidator';
import { debounceTime, fromEvent, catchError, combineLatest, distinctUntilChanged, of, Observer, Subscription, map, Observable, Subject } from 'rxjs';
import { BsModalService, ModalOptions, BsModalRef } from 'ngx-bootstrap/modal';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { OnInit, ElementRef, Renderer2, ViewChild, Component } from '@angular/core';
import { AppGlobalService } from '@baseapp/app-global.service';
import { GridComponent } from '@baseapp/widgets/grid/grid.component';
import { DomSanitizer } from '@angular/platform-browser';
import { DialogService } from 'primeng/dynamicdialog';
import { Filter } from '@baseapp/vs-models/filter.model';
import { AppConstants } from '@app/app-constants';
import { Table1Service } from '@baseapp/table1/table1/table1.service';
import { ConfirmationService, MessageService } from 'primeng/api';
import { TranslateService } from '@ngx-translate/core';
import { ChangeLogsComponent } from '@baseapp/widgets/change-logs/change-logs.component';
import { environment } from '@env/environment';
import { Table1ListBaseComponent } from '@baseapp/table1/table1/table1-list/table1-list.base.component';
import { AppUtilBaseService } from '@baseapp/app-util.base.service';


@Component({
  selector: 'app-table1-list',
  templateUrl: '../../../../../base/app/table1/table1/table1-list/table1-list.component.html',
  styleUrls: ['./table1-list.scss']
})
export class Table1ListComponent extends Table1ListBaseComponent implements OnInit {
 
  constructor(public override table1Service: Table1Service, public override appUtilBaseService: AppUtilBaseService, public override translateService: TranslateService, public override messageService: MessageService, public override confirmationService: ConfirmationService, public override dialogService: DialogService, public override domSanitizer: DomSanitizer, public override bsModalService: BsModalService, public override activatedRoute: ActivatedRoute, public override renderer2: Renderer2, public override router: Router, public override appGlobalService: AppGlobalService) {
    super(table1Service, appUtilBaseService, translateService, messageService, confirmationService, dialogService, domSanitizer, bsModalService, activatedRoute, renderer2, router, appGlobalService);
  }
	
  ngAfterViewInit(): void {
    this.onAfterViewInit()
  }

  ngOnInit(): void {
    super.onInit();
  }
 
}