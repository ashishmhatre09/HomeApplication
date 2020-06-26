import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HomeApplicationSharedModule } from 'app/shared/shared.module';
import { IDBCompanyDetailsComponent } from './idb-company-details.component';
import { IDBCompanyDetailsDetailComponent } from './idb-company-details-detail.component';
import { IDBCompanyDetailsUpdateComponent } from './idb-company-details-update.component';
import { IDBCompanyDetailsDeleteDialogComponent } from './idb-company-details-delete-dialog.component';
import { iDBCompanyDetailsRoute } from './idb-company-details.route';

@NgModule({
    imports: [HomeApplicationSharedModule, RouterModule.forChild(iDBCompanyDetailsRoute)],
    declarations: [
        IDBCompanyDetailsComponent,
        IDBCompanyDetailsDetailComponent,
        IDBCompanyDetailsUpdateComponent,
        IDBCompanyDetailsDeleteDialogComponent,
    ],
    entryComponents: [IDBCompanyDetailsDeleteDialogComponent],
})
export class HomeApplicationIDBCompanyDetailsModule {}
