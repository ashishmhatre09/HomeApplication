import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IIDBCompanyDetails, IDBCompanyDetails } from 'app/shared/model/idb-company-details.model';
import { IDBCompanyDetailsService } from './idb-company-details.service';
import { IDBCompanyDetailsComponent } from './idb-company-details.component';
import { IDBCompanyDetailsDetailComponent } from './idb-company-details-detail.component';
import { IDBCompanyDetailsUpdateComponent } from './idb-company-details-update.component';

@Injectable({ providedIn: 'root' })
export class IDBCompanyDetailsResolve implements Resolve<IIDBCompanyDetails> {
    constructor(private service: IDBCompanyDetailsService, private router: Router) {}

    resolve(route: ActivatedRouteSnapshot): Observable<IIDBCompanyDetails> | Observable<never> {
        const id = route.params['id'];
        if (id) {
            return this.service.find(id).pipe(
                flatMap((iDBCompanyDetails: HttpResponse<IDBCompanyDetails>) => {
                    if (iDBCompanyDetails.body) {
                        return of(iDBCompanyDetails.body);
                    } else {
                        this.router.navigate(['404']);
                        return EMPTY;
                    }
                })
            );
        }
        return of(new IDBCompanyDetails());
    }
}

export const iDBCompanyDetailsRoute: Routes = [
    {
        path: '',
        component: IDBCompanyDetailsComponent,
        data: {
            authorities: [Authority.USER],
            pageTitle: 'IDBCompanyDetails',
        },
        canActivate: [UserRouteAccessService],
    },
    {
        path: ':id/view',
        component: IDBCompanyDetailsDetailComponent,
        resolve: {
            iDBCompanyDetails: IDBCompanyDetailsResolve,
        },
        data: {
            authorities: [Authority.USER],
            pageTitle: 'IDBCompanyDetails',
        },
        canActivate: [UserRouteAccessService],
    },
    {
        path: 'new',
        component: IDBCompanyDetailsUpdateComponent,
        resolve: {
            iDBCompanyDetails: IDBCompanyDetailsResolve,
        },
        data: {
            authorities: [Authority.USER],
            pageTitle: 'IDBCompanyDetails',
        },
        canActivate: [UserRouteAccessService],
    },
    {
        path: ':id/edit',
        component: IDBCompanyDetailsUpdateComponent,
        resolve: {
            iDBCompanyDetails: IDBCompanyDetailsResolve,
        },
        data: {
            authorities: [Authority.USER],
            pageTitle: 'IDBCompanyDetails',
        },
        canActivate: [UserRouteAccessService],
    },
];
