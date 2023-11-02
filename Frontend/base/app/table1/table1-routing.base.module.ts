import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';

import { Table1ListComponent } from '@app/table1/table1/table1-list/table1-list.component';
import { Table1DetailComponent } from '@app/table1/table1/table1-detail/table1-detail.component';

export const routes: Routes = [

{
     path: 'table1list',
     component: Table1ListComponent,
     canDeactivate: [ CanDeactivateGuard ],
     data: {
     	label: "TABLE1_LIST",
        breadcrumb: "TABLE1_LIST",
        roles : [
        			"all"
				]
     }
},
{
     path: 'table1detail',
     component: Table1DetailComponent,
     canDeactivate: [ CanDeactivateGuard ],
     data: {
     	label: "TABLE1_DETAIL",
        breadcrumb: "TABLE1_DETAIL",
        roles : [
        			"all"
				]
     }
}
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class Table1BaseRoutingModule
{
}
