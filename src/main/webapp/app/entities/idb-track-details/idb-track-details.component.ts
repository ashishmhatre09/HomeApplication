import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IIDBTrackDetails } from 'app/shared/model/idb-track-details.model';
import { IDBTrackDetailsService } from './idb-track-details.service';
import { IDBTrackDetailsDeleteDialogComponent } from './idb-track-details-delete-dialog.component';

@Component({
    selector: 'jhi-idb-track-details',
    templateUrl: './idb-track-details.component.html',
})
export class IDBTrackDetailsComponent implements OnInit, OnDestroy {
    iDBTrackDetails?: IIDBTrackDetails[];
    eventSubscriber?: Subscription;

    constructor(
        protected iDBTrackDetailsService: IDBTrackDetailsService,
        protected eventManager: JhiEventManager,
        protected modalService: NgbModal
    ) {}

    loadAll(): void {
        this.iDBTrackDetailsService.query().subscribe((res: HttpResponse<IIDBTrackDetails[]>) => (this.iDBTrackDetails = res.body || []));
    }

    ngOnInit(): void {
        this.loadAll();
        this.registerChangeInIDBTrackDetails();
    }

    ngOnDestroy(): void {
        if (this.eventSubscriber) {
            this.eventManager.destroy(this.eventSubscriber);
        }
    }

    trackId(index: number, item: IIDBTrackDetails): number {
        // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
        return item.id!;
    }

    registerChangeInIDBTrackDetails(): void {
        this.eventSubscriber = this.eventManager.subscribe('iDBTrackDetailsListModification', () => this.loadAll());
    }

    delete(iDBTrackDetails: IIDBTrackDetails): void {
        const modalRef = this.modalService.open(IDBTrackDetailsDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
        modalRef.componentInstance.iDBTrackDetails = iDBTrackDetails;
    }
}
