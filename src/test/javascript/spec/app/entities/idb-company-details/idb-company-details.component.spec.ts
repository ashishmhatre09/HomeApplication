import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { HomeApplicationTestModule } from '../../../test.module';
import { IDBCompanyDetailsComponent } from 'app/entities/idb-company-details/idb-company-details.component';
import { IDBCompanyDetailsService } from 'app/entities/idb-company-details/idb-company-details.service';
import { IDBCompanyDetails } from 'app/shared/model/idb-company-details.model';

describe('Component Tests', () => {
    describe('IDBCompanyDetails Management Component', () => {
        let comp: IDBCompanyDetailsComponent;
        let fixture: ComponentFixture<IDBCompanyDetailsComponent>;
        let service: IDBCompanyDetailsService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HomeApplicationTestModule],
                declarations: [IDBCompanyDetailsComponent],
            })
                .overrideTemplate(IDBCompanyDetailsComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(IDBCompanyDetailsComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(IDBCompanyDetailsService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new IDBCompanyDetails(123)],
                        headers,
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.iDBCompanyDetails && comp.iDBCompanyDetails[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
