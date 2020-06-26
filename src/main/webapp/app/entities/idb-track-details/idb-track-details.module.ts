import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HomeApplicationSharedModule } from 'app/shared/shared.module';
import { IDBTrackDetailsComponent } from './idb-track-details.component';
import { IDBTrackDetailsDetailComponent } from './idb-track-details-detail.component';
import { IDBTrackDetailsUpdateComponent } from './idb-track-details-update.component';
import { IDBTrackDetailsDeleteDialogComponent } from './idb-track-details-delete-dialog.component';
import { iDBTrackDetailsRoute } from './idb-track-details.route';

@NgModule({
    imports: [HomeApplicationSharedModule, RouterModule.forChild(iDBTrackDetailsRoute)],
    declarations: [
        IDBTrackDetailsComponent,
        IDBTrackDetailsDetailComponent,
        IDBTrackDetailsUpdateComponent,
        IDBTrackDetailsDeleteDialogComponent,
    ],
    entryComponents: [IDBTrackDetailsDeleteDialogComponent],
})
export class HomeApplicationIDBTrackDetailsModule {}
