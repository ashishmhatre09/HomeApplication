import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IIDBCompanyDetails } from 'app/shared/model/idb-company-details.model';
import { IDBCompanyDetailsService } from './idb-company-details.service';
import { IDBCompanyDetailsDeleteDialogComponent } from './idb-company-details-delete-dialog.component';

@Component({
    selector: 'jhi-idb-company-details',
    templateUrl: './idb-company-details.component.html',
})
export class IDBCompanyDetailsComponent implements OnInit, OnDestroy {
    iDBCompanyDetails?: IIDBCompanyDetails[];
    eventSubscriber?: Subscription;

    constructor(
        protected iDBCompanyDetailsService: IDBCompanyDetailsService,
        protected eventManager: JhiEventManager,
        protected modalService: NgbModal
    ) {}

    loadAll(): void {
        this.iDBCompanyDetailsService
            .query()
            .subscribe((res: HttpResponse<IIDBCompanyDetails[]>) => (this.iDBCompanyDetails = res.body || []));
    }

    ngOnInit(): void {
        this.loadAll();
        this.registerChangeInIDBCompanyDetails();
    }

    ngOnDestroy(): void {
        if (this.eventSubscriber) {
            this.eventManager.destroy(this.eventSubscriber);
        }
    }

    trackId(index: number, item: IIDBCompanyDetails): number {
        // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
        return item.id!;
    }

    registerChangeInIDBCompanyDetails(): void {
        this.eventSubscriber = this.eventManager.subscribe('iDBCompanyDetailsListModification', () => this.loadAll());
    }

    delete(iDBCompanyDetails: IIDBCompanyDetails): void {
        const modalRef = this.modalService.open(IDBCompanyDetailsDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
        modalRef.componentInstance.iDBCompanyDetails = iDBCompanyDetails;
    }
}
