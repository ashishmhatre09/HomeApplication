import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { HomeApplicationTestModule } from '../../../test.module';
import { IDBTrackDetailsUpdateComponent } from 'app/entities/idb-track-details/idb-track-details-update.component';
import { IDBTrackDetailsService } from 'app/entities/idb-track-details/idb-track-details.service';
import { IDBTrackDetails } from 'app/shared/model/idb-track-details.model';

describe('Component Tests', () => {
    describe('IDBTrackDetails Management Update Component', () => {
        let comp: IDBTrackDetailsUpdateComponent;
        let fixture: ComponentFixture<IDBTrackDetailsUpdateComponent>;
        let service: IDBTrackDetailsService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HomeApplicationTestModule],
                declarations: [IDBTrackDetailsUpdateComponent],
                providers: [FormBuilder],
            })
                .overrideTemplate(IDBTrackDetailsUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(IDBTrackDetailsUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(IDBTrackDetailsService);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity', fakeAsync(() => {
                // GIVEN
                const entity = new IDBTrackDetails(123);
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
                const entity = new IDBTrackDetails();
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
