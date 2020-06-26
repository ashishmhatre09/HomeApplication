import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IIDBTrackDetails } from 'app/shared/model/idb-track-details.model';
import { IDBTrackDetailsService } from './idb-track-details.service';

@Component({
    templateUrl: './idb-track-details-delete-dialog.component.html',
})
export class IDBTrackDetailsDeleteDialogComponent {
    iDBTrackDetails?: IIDBTrackDetails;

    constructor(
        protected iDBTrackDetailsService: IDBTrackDetailsService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}

    cancel(): void {
        this.activeModal.dismiss();
    }

    confirmDelete(id: number): void {
        this.iDBTrackDetailsService.delete(id).subscribe(() => {
            this.eventManager.broadcast('iDBTrackDetailsListModification');
            this.activeModal.close();
        });
    }
}
