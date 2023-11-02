import { NgModule } from '@angular/core';
import { SharedModule } from '@app/shared/shared.module';
import { Table1ListComponent } from '@app/table1/table1/table1-list/table1-list.component';
import { BsModalService } from 'ngx-bootstrap/modal';
import { WidgetsBaseModule } from '@baseapp/widgets/widgets.base.module';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';
import { Table1DetailComponent } from '@app/table1/table1/table1-detail/table1-detail.component';

@NgModule({
  declarations: [
Table1ListComponent,
Table1DetailComponent
],
imports: [
SharedModule,
WidgetsBaseModule
],

exports: [
SharedModule,
WidgetsBaseModule,
Table1ListComponent,
Table1DetailComponent
],

providers: [
BsModalService,
CanDeactivateGuard
],
  
})
export class Table1BaseModule { }