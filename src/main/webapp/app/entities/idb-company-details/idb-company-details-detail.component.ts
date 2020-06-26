import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IIDBCompanyDetails } from 'app/shared/model/idb-company-details.model';

@Component({
    selector: 'jhi-idb-company-details-detail',
    templateUrl: './idb-company-details-detail.component.html',
})
export class IDBCompanyDetailsDetailComponent implements OnInit {
    iDBCompanyDetails: IIDBCompanyDetails | null = null;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit(): void {
        this.activatedRoute.data.subscribe(({ iDBCompanyDetails }) => (this.iDBCompanyDetails = iDBCompanyDetails));
    }

    previousState(): void {
        window.history.back();
    }
}
