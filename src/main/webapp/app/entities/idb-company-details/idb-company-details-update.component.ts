import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IIDBCompanyDetails, IDBCompanyDetails } from 'app/shared/model/idb-company-details.model';
import { IDBCompanyDetailsService } from './idb-company-details.service';

@Component({
    selector: 'jhi-idb-company-details-update',
    templateUrl: './idb-company-details-update.component.html',
})
export class IDBCompanyDetailsUpdateComponent implements OnInit {
    isSaving = false;

    editForm = this.fb.group({
        id: [],
        companyCode: [],
        companyName: [],
        meetingNumber: [],
        meetingDate: [],
        prDate: [],
        crrDate: [],
        osLtRating: [],
        osStRating: [],
        osOutlook: [],
        osOtherRating: [],
        assignedLtRating: [],
        assignedStRating: [],
        assignedOutlook: [],
        assignedOtherRating: [],
        companyClassification: [],
        osLtRtgCategory: [],
        osStRtgCategory: [],
        executingDepartment: [],
        createdOn: [],
    });

    constructor(
        protected iDBCompanyDetailsService: IDBCompanyDetailsService,
        protected activatedRoute: ActivatedRoute,
        private fb: FormBuilder
    ) {}

    ngOnInit(): void {
        this.activatedRoute.data.subscribe(({ iDBCompanyDetails }) => {
            if (!iDBCompanyDetails.id) {
                const today = moment().startOf('day');
                iDBCompanyDetails.meetingDate = today;
                iDBCompanyDetails.prDate = today;
                iDBCompanyDetails.crrDate = today;
                iDBCompanyDetails.createdOn = today;
            }

            this.updateForm(iDBCompanyDetails);
        });
    }

    updateForm(iDBCompanyDetails: IIDBCompanyDetails): void {
        this.editForm.patchValue({
            id: iDBCompanyDetails.id,
            companyCode: iDBCompanyDetails.companyCode,
            companyName: iDBCompanyDetails.companyName,
            meetingNumber: iDBCompanyDetails.meetingNumber,
            meetingDate: iDBCompanyDetails.meetingDate ? iDBCompanyDetails.meetingDate.format(DATE_TIME_FORMAT) : null,
            prDate: iDBCompanyDetails.prDate ? iDBCompanyDetails.prDate.format(DATE_TIME_FORMAT) : null,
            crrDate: iDBCompanyDetails.crrDate ? iDBCompanyDetails.crrDate.format(DATE_TIME_FORMAT) : null,
            osLtRating: iDBCompanyDetails.osLtRating,
            osStRating: iDBCompanyDetails.osStRating,
            osOutlook: iDBCompanyDetails.osOutlook,
            osOtherRating: iDBCompanyDetails.osOtherRating,
            assignedLtRating: iDBCompanyDetails.assignedLtRating,
            assignedStRating: iDBCompanyDetails.assignedStRating,
            assignedOutlook: iDBCompanyDetails.assignedOutlook,
            assignedOtherRating: iDBCompanyDetails.assignedOtherRating,
            companyClassification: iDBCompanyDetails.companyClassification,
            osLtRtgCategory: iDBCompanyDetails.osLtRtgCategory,
            osStRtgCategory: iDBCompanyDetails.osStRtgCategory,
            executingDepartment: iDBCompanyDetails.executingDepartment,
            createdOn: iDBCompanyDetails.createdOn ? iDBCompanyDetails.createdOn.format(DATE_TIME_FORMAT) : null,
        });
    }

    previousState(): void {
        window.history.back();
    }

    save(): void {
        this.isSaving = true;
        const iDBCompanyDetails = this.createFromForm();
        if (iDBCompanyDetails.id !== undefined) {
            this.subscribeToSaveResponse(this.iDBCompanyDetailsService.update(iDBCompanyDetails));
        } else {
            this.subscribeToSaveResponse(this.iDBCompanyDetailsService.create(iDBCompanyDetails));
        }
    }

    private createFromForm(): IIDBCompanyDetails {
        return {
            ...new IDBCompanyDetails(),
            id: this.editForm.get(['id'])!.value,
            companyCode: this.editForm.get(['companyCode'])!.value,
            companyName: this.editForm.get(['companyName'])!.value,
            meetingNumber: this.editForm.get(['meetingNumber'])!.value,
            meetingDate: this.editForm.get(['meetingDate'])!.value
                ? moment(this.editForm.get(['meetingDate'])!.value, DATE_TIME_FORMAT)
                : undefined,
            prDate: this.editForm.get(['prDate'])!.value ? moment(this.editForm.get(['prDate'])!.value, DATE_TIME_FORMAT) : undefined,
            crrDate: this.editForm.get(['crrDate'])!.value ? moment(this.editForm.get(['crrDate'])!.value, DATE_TIME_FORMAT) : undefined,
            osLtRating: this.editForm.get(['osLtRating'])!.value,
            osStRating: this.editForm.get(['osStRating'])!.value,
            osOutlook: this.editForm.get(['osOutlook'])!.value,
            osOtherRating: this.editForm.get(['osOtherRating'])!.value,
            assignedLtRating: this.editForm.get(['assignedLtRating'])!.value,
            assignedStRating: this.editForm.get(['assignedStRating'])!.value,
            assignedOutlook: this.editForm.get(['assignedOutlook'])!.value,
            assignedOtherRating: this.editForm.get(['assignedOtherRating'])!.value,
            companyClassification: this.editForm.get(['companyClassification'])!.value,
            osLtRtgCategory: this.editForm.get(['osLtRtgCategory'])!.value,
            osStRtgCategory: this.editForm.get(['osStRtgCategory'])!.value,
            executingDepartment: this.editForm.get(['executingDepartment'])!.value,
            createdOn: this.editForm.get(['createdOn'])!.value
                ? moment(this.editForm.get(['createdOn'])!.value, DATE_TIME_FORMAT)
                : undefined,
        };
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IIDBCompanyDetails>>): void {
        result.subscribe(
            () => this.onSaveSuccess(),
            () => this.onSaveError()
        );
    }

    protected onSaveSuccess(): void {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError(): void {
        this.isSaving = false;
    }
}
