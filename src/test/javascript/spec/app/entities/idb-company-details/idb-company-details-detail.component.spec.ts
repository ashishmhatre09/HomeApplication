import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { HomeApplicationTestModule } from '../../../test.module';
import { IDBCompanyDetailsDetailComponent } from 'app/entities/idb-company-details/idb-company-details-detail.component';
import { IDBCompanyDetails } from 'app/shared/model/idb-company-details.model';

describe('Component Tests', () => {
    describe('IDBCompanyDetails Management Detail Component', () => {
        let comp: IDBCompanyDetailsDetailComponent;
        let fixture: ComponentFixture<IDBCompanyDetailsDetailComponent>;
        const route = ({ data: of({ iDBCompanyDetails: new IDBCompanyDetails(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HomeApplicationTestModule],
                declarations: [IDBCompanyDetailsDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }],
            })
                .overrideTemplate(IDBCompanyDetailsDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(IDBCompanyDetailsDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should load iDBCompanyDetails on init', () => {
                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.iDBCompanyDetails).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
