import { RouterModule, Routes } from '@angular/router';
import { AppLayoutComponent } from '@app/app-layout/app-layout.component';

export const routes: Routes = [{
  path: 'auth',
  children: [
    {
      path: '',
      loadChildren: () => import('@app/auth/auth.module').then(m => m.AuthModule)
    },
    {
      path:'exports',
      loadChildren:() => import ('@app/exports/exports.module').then(m =>m.ExportsModule)
    },
    {
      path:'imports',
      loadChildren:() => import('@app/imports/imports.module').then(m=>m.ImportsModule)
    },
    {
        path: 'usermanagement',
        loadChildren: () => import('@app/user-settings/user-settings.module').then(m=>m.UserSettingsModule)
      }
  ]
},
{
  path: '',
  component: AppLayoutComponent,  
  children: []
}];

