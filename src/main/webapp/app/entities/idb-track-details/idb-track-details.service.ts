import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IIDBTrackDetails } from 'app/shared/model/idb-track-details.model';

type EntityResponseType = HttpResponse<IIDBTrackDetails>;
type EntityArrayResponseType = HttpResponse<IIDBTrackDetails[]>;

@Injectable({ providedIn: 'root' })
export class IDBTrackDetailsService {
    public resourceUrl = SERVER_API_URL + 'api/idb-track-details';

    constructor(protected http: HttpClient) {}

    create(iDBTrackDetails: IIDBTrackDetails): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(iDBTrackDetails);
        return this.http
            .post<IIDBTrackDetails>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(iDBTrackDetails: IIDBTrackDetails): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(iDBTrackDetails);
        return this.http
            .put<IIDBTrackDetails>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<IIDBTrackDetails>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IIDBTrackDetails[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<{}>> {
        return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    protected convertDateFromClient(iDBTrackDetails: IIDBTrackDetails): IIDBTrackDetails {
        const copy: IIDBTrackDetails = Object.assign({}, iDBTrackDetails, {
            targetDate:
                iDBTrackDetails.targetDate && iDBTrackDetails.targetDate.isValid() ? iDBTrackDetails.targetDate.toJSON() : undefined,
            createdOn: iDBTrackDetails.createdOn && iDBTrackDetails.createdOn.isValid() ? iDBTrackDetails.createdOn.toJSON() : undefined,
        });
        return copy;
    }

    protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
        if (res.body) {
            res.body.targetDate = res.body.targetDate ? moment(res.body.targetDate) : undefined;
            res.body.createdOn = res.body.createdOn ? moment(res.body.createdOn) : undefined;
        }
        return res;
    }

    protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        if (res.body) {
            res.body.forEach((iDBTrackDetails: IIDBTrackDetails) => {
                iDBTrackDetails.targetDate = iDBTrackDetails.targetDate ? moment(iDBTrackDetails.targetDate) : undefined;
                iDBTrackDetails.createdOn = iDBTrackDetails.createdOn ? moment(iDBTrackDetails.createdOn) : undefined;
            });
        }
        return res;
    }
}
