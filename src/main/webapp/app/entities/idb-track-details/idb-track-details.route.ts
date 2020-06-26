import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IIDBTrackDetails, IDBTrackDetails } from 'app/shared/model/idb-track-details.model';
import { IDBTrackDetailsService } from './idb-track-details.service';
import { IDBTrackDetailsComponent } from './idb-track-details.component';
import { IDBTrackDetailsDetailComponent } from './idb-track-details-detail.component';
import { IDBTrackDetailsUpdateComponent } from './idb-track-details-update.component';

@Injectable({ providedIn: 'root' })
export class IDBTrackDetailsResolve implements Resolve<IIDBTrackDetails> {
    constructor(private service: IDBTrackDetailsService, private router: Router) {}

    resolve(route: ActivatedRouteSnapshot): Observable<IIDBTrackDetails> | Observable<never> {
        const id = route.params['id'];
        if (id) {
            return this.service.find(id).pipe(
                flatMap((iDBTrackDetails: HttpResponse<IDBTrackDetails>) => {
                    if (iDBTrackDetails.body) {
                        return of(iDBTrackDetails.body);
                    } else {
                        this.router.navigate(['404']);
                        return EMPTY;
                    }
                })
            );
        }
        return of(new IDBTrackDetails());
    }
}

export const iDBTrackDetailsRoute: Routes = [
    {
        path: '',
        component: IDBTrackDetailsComponent,
        data: {
            authorities: [Authority.USER],
            pageTitle: 'IDBTrackDetails',
        },
        canActivate: [UserRouteAccessService],
    },
    {
        path: ':id/view',
        component: IDBTrackDetailsDetailComponent,
        resolve: {
            iDBTrackDetails: IDBTrackDetailsResolve,
        },
        data: {
            authorities: [Authority.USER],
            pageTitle: 'IDBTrackDetails',
        },
        canActivate: [UserRouteAccessService],
    },
    {
        path: 'new',
        component: IDBTrackDetailsUpdateComponent,
        resolve: {
            iDBTrackDetails: IDBTrackDetailsResolve,
        },
        data: {
            authorities: [Authority.USER],
            pageTitle: 'IDBTrackDetails',
        },
        canActivate: [UserRouteAccessService],
    },
    {
        path: ':id/edit',
        component: IDBTrackDetailsUpdateComponent,
        resolve: {
            iDBTrackDetails: IDBTrackDetailsResolve,
        },
        data: {
            authorities: [Authority.USER],
            pageTitle: 'IDBTrackDetails',
        },
        canActivate: [UserRouteAccessService],
    },
];
