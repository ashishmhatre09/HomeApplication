import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IIDBCompanyDetails } from 'app/shared/model/idb-company-details.model';

type EntityResponseType = HttpResponse<IIDBCompanyDetails>;
type EntityArrayResponseType = HttpResponse<IIDBCompanyDetails[]>;

@Injectable({ providedIn: 'root' })
export class IDBCompanyDetailsService {
    public resourceUrl = SERVER_API_URL + 'api/idb-company-details';

    constructor(protected http: HttpClient) {}

    create(iDBCompanyDetails: IIDBCompanyDetails): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(iDBCompanyDetails);
        return this.http
            .post<IIDBCompanyDetails>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(iDBCompanyDetails: IIDBCompanyDetails): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(iDBCompanyDetails);
        return this.http
            .put<IIDBCompanyDetails>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IIDBCompanyDetails>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IIDBCompanyDetails[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<{}>> {
        return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    protected convertDateFromClient(iDBCompanyDetails: IIDBCompanyDetails): IIDBCompanyDetails {
        const copy: IIDBCompanyDetails = Object.assign({}, iDBCompanyDetails, {
            meetingDate:
                iDBCompanyDetails.meetingDate && iDBCompanyDetails.meetingDate.isValid()
                    ? iDBCompanyDetails.meetingDate.toJSON()
                    : undefined,
            prDate: iDBCompanyDetails.prDate && iDBCompanyDetails.prDate.isValid() ? iDBCompanyDetails.prDate.toJSON() : undefined,
            crrDate: iDBCompanyDetails.crrDate && iDBCompanyDetails.crrDate.isValid() ? iDBCompanyDetails.crrDate.toJSON() : undefined,
            createdOn:
                iDBCompanyDetails.createdOn && iDBCompanyDetails.createdOn.isValid() ? iDBCompanyDetails.createdOn.toJSON() : undefined,
        });
        return copy;
    }

    protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
        if (res.body) {
            res.body.meetingDate = res.body.meetingDate ? moment(res.body.meetingDate) : undefined;
            res.body.prDate = res.body.prDate ? moment(res.body.prDate) : undefined;
            res.body.crrDate = res.body.crrDate ? moment(res.body.crrDate) : undefined;
            res.body.createdOn = res.body.createdOn ? moment(res.body.createdOn) : undefined;
        }
        return res;
    }

    protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        if (res.body) {
            res.body.forEach((iDBCompanyDetails: IIDBCompanyDetails) => {
                iDBCompanyDetails.meetingDate = iDBCompanyDetails.meetingDate ? moment(iDBCompanyDetails.meetingDate) : undefined;
                iDBCompanyDetails.prDate = iDBCompanyDetails.prDate ? moment(iDBCompanyDetails.prDate) : undefined;
                iDBCompanyDetails.crrDate = iDBCompanyDetails.crrDate ? moment(iDBCompanyDetails.crrDate) : undefined;
                iDBCompanyDetails.createdOn = iDBCompanyDetails.createdOn ? moment(iDBCompanyDetails.createdOn) : undefined;
            });
        }
        return res;
    }
}
