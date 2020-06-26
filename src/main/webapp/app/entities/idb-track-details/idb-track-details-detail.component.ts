import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IIDBTrackDetails } from 'app/shared/model/idb-track-details.model';

@Component({
    selector: 'jhi-idb-track-details-detail',
    templateUrl: './idb-track-details-detail.component.html',
})
export class IDBTrackDetailsDetailComponent implements OnInit {
    iDBTrackDetails: IIDBTrackDetails | null = null;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit(): void {
        this.activatedRoute.data.subscribe(({ iDBTrackDetails }) => (this.iDBTrackDetails = iDBTrackDetails));
    }

    previousState(): void {
        window.history.back();
    }
}
