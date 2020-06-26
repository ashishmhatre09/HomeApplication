import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { HomeApplicationTestModule } from '../../../test.module';
import { IDBCompanyDetailsUpdateComponent } from 'app/entities/idb-company-details/idb-company-details-update.component';
import { IDBCompanyDetailsService } from 'app/entities/idb-company-details/idb-company-details.service';
import { IDBCompanyDetails } from 'app/shared/model/idb-company-details.model';

describe('Component Tests', () => {
    describe('IDBCompanyDetails Management Update Component', () => {
        let comp: IDBCompanyDetailsUpdateComponent;
        let fixture: ComponentFixture<IDBCompanyDetailsUpdateComponent>;
        let service: IDBCompanyDetailsService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HomeApplicationTestModule],
                declarations: [IDBCompanyDetailsUpdateComponent],
                providers: [FormBuilder],
            })
                .overrideTemplate(IDBCompanyDetailsUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(IDBCompanyDetailsUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(IDBCompanyDetailsService);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity', fakeAsync(() => {
                // GIVEN
                const entity = new IDBCompanyDetails(123);
                spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                comp.updateForm(entity);
                // WHEN
                comp.save();
                tick(); // simulate async

                // THEN
                expect(service.update).toHaveBeenCalledWith(entity);
                expect(comp.isSaving).toEqual(false);
            }));

            it('Should call create service on save for new entity', fakeAsync(() => {
                // GIVEN
                const entity = new IDBCompanyDetails();
                spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                comp.updateForm(entity);
                // WHEN
                comp.save();
                tick(); // simulate async

                // THEN
                expect(service.create).toHaveBeenCalledWith(entity);
                expect(comp.isSaving).toEqual(false);
            }));
        });
    });
});
