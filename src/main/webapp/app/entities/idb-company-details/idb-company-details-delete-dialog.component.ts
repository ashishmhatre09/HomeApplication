import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IIDBCompanyDetails } from 'app/shared/model/idb-company-details.model';
import { IDBCompanyDetailsService } from './idb-company-details.service';

@Component({
    templateUrl: './idb-company-details-delete-dialog.component.html',
})
export class IDBCompanyDetailsDeleteDialogComponent {
    iDBCompanyDetails?: IIDBCompanyDetails;

    constructor(
        protected iDBCompanyDetailsService: IDBCompanyDetailsService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}

    cancel(): void {
        this.activeModal.dismiss();
    }

    confirmDelete(id: number): void {
        this.iDBCompanyDetailsService.delete(id).subscribe(() => {
            this.eventManager.broadcast('iDBCompanyDetailsListModification');
            this.activeModal.close();
        });
    }
}
