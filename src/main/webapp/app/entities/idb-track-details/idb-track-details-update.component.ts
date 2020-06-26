import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IIDBTrackDetails, IDBTrackDetails } from 'app/shared/model/idb-track-details.model';
import { IDBTrackDetailsService } from './idb-track-details.service';
import { IIDBCompanyDetails } from 'app/shared/model/idb-company-details.model';
import { IDBCompanyDetailsService } from 'app/entities/idb-company-details/idb-company-details.service';

@Component({
    selector: 'jhi-idb-track-details-update',
    templateUrl: './idb-track-details-update.component.html',
})
export class IDBTrackDetailsUpdateComponent implements OnInit {
    isSaving = false;
    idbcompanydetails: IIDBCompanyDetails[] = [];

    editForm = this.fb.group({
        id: [],
        companyCode: [],
        assignmentId: [],
        trackId: [],
        numberOfDays: [],
        employeeId: [],
        employeeName: [],
        levelId: [],
        listed: [],
        withdrawalOption: [],
        assigneLtRating: [],
        assigneStRating: [],
        assignedOutlook: [],
        assignedOtherRating: [],
        totalNumberofDays: [],
        companyClassification: [],
        reason: [],
        comments: [],
        targetDate: [],
        createdOn: [],
        executingDepartment: [],
        companyName: [],
        companyCode: [],
    });

    constructor(
        protected iDBTrackDetailsService: IDBTrackDetailsService,
        protected iDBCompanyDetailsService: IDBCompanyDetailsService,
        protected activatedRoute: ActivatedRoute,
        private fb: FormBuilder
    ) {}

    ngOnInit(): void {
        this.activatedRoute.data.subscribe(({ iDBTrackDetails }) => {
            if (!iDBTrackDetails.id) {
                const today = moment().startOf('day');
                iDBTrackDetails.targetDate = today;
                iDBTrackDetails.createdOn = today;
            }

            this.updateForm(iDBTrackDetails);

            this.iDBCompanyDetailsService
                .query()
                .subscribe((res: HttpResponse<IIDBCompanyDetails[]>) => (this.idbcompanydetails = res.body || []));
        });
    }

    updateForm(iDBTrackDetails: IIDBTrackDetails): void {
        this.editForm.patchValue({
            id: iDBTrackDetails.id,
            companyCode: iDBTrackDetails.companyCode,
            assignmentId: iDBTrackDetails.assignmentId,
            trackId: iDBTrackDetails.trackId,
            numberOfDays: iDBTrackDetails.numberOfDays,
            employeeId: iDBTrackDetails.employeeId,
            employeeName: iDBTrackDetails.employeeName,
            levelId: iDBTrackDetails.levelId,
            listed: iDBTrackDetails.listed,
            withdrawalOption: iDBTrackDetails.withdrawalOption,
            assigneLtRating: iDBTrackDetails.assigneLtRating,
            assigneStRating: iDBTrackDetails.assigneStRating,
            assignedOutlook: iDBTrackDetails.assignedOutlook,
            assignedOtherRating: iDBTrackDetails.assignedOtherRating,
            totalNumberofDays: iDBTrackDetails.totalNumberofDays,
            companyClassification: iDBTrackDetails.companyClassification,
            reason: iDBTrackDetails.reason,
            comments: iDBTrackDetails.comments,
            targetDate: iDBTrackDetails.targetDate ? iDBTrackDetails.targetDate.format(DATE_TIME_FORMAT) : null,
            createdOn: iDBTrackDetails.createdOn ? iDBTrackDetails.createdOn.format(DATE_TIME_FORMAT) : null,
            executingDepartment: iDBTrackDetails.executingDepartment,
            companyName: iDBTrackDetails.companyName,
            companyCode: iDBTrackDetails.companyCode,
        });
    }

    previousState(): void {
        window.history.back();
    }

    save(): void {
        this.isSaving = true;
        const iDBTrackDetails = this.createFromForm();
        if (iDBTrackDetails.id !== undefined) {
            this.subscribeToSaveResponse(this.iDBTrackDetailsService.update(iDBTrackDetails));
        } else {
            this.subscribeToSaveResponse(this.iDBTrackDetailsService.create(iDBTrackDetails));
        }
    }

    private createFromForm(): IIDBTrackDetails {
        return {
            ...new IDBTrackDetails(),
            id: this.editForm.get(['id'])!.value,
            companyCode: this.editForm.get(['companyCode'])!.value,
            assignmentId: this.editForm.get(['assignmentId'])!.value,
            trackId: this.editForm.get(['trackId'])!.value,
            numberOfDays: this.editForm.get(['numberOfDays'])!.value,
            employeeId: this.editForm.get(['employeeId'])!.value,
            employeeName: this.editForm.get(['employeeName'])!.value,
            levelId: this.editForm.get(['levelId'])!.value,
            listed: this.editForm.get(['listed'])!.value,
            withdrawalOption: this.editForm.get(['withdrawalOption'])!.value,
            assigneLtRating: this.editForm.get(['assigneLtRating'])!.value,
            assigneStRating: this.editForm.get(['assigneStRating'])!.value,
            assignedOutlook: this.editForm.get(['assignedOutlook'])!.value,
            assignedOtherRating: this.editForm.get(['assignedOtherRating'])!.value,
            totalNumberofDays: this.editForm.get(['totalNumberofDays'])!.value,
            companyClassification: this.editForm.get(['companyClassification'])!.value,
            reason: this.editForm.get(['reason'])!.value,
            comments: this.editForm.get(['comments'])!.value,
            targetDate: this.editForm.get(['targetDate'])!.value
                ? moment(this.editForm.get(['targetDate'])!.value, DATE_TIME_FORMAT)
                : undefined,
            createdOn: this.editForm.get(['createdOn'])!.value
                ? moment(this.editForm.get(['createdOn'])!.value, DATE_TIME_FORMAT)
                : undefined,
            executingDepartment: this.editForm.get(['executingDepartment'])!.value,
            companyName: this.editForm.get(['companyName'])!.value,
            companyCode: this.editForm.get(['companyCode'])!.value,
        };
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IIDBTrackDetails>>): void {
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

    trackById(index: number, item: IIDBCompanyDetails): any {
        return item.id;
    }
}
