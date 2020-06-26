import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { HomeApplicationTestModule } from '../../../test.module';
import { MockEventManager } from '../../../helpers/mock-event-manager.service';
import { MockActiveModal } from '../../../helpers/mock-active-modal.service';
import { IDBTrackDetailsDeleteDialogComponent } from 'app/entities/idb-track-details/idb-track-details-delete-dialog.component';
import { IDBTrackDetailsService } from 'app/entities/idb-track-details/idb-track-details.service';

describe('Component Tests', () => {
    describe('IDBTrackDetails Management Delete Component', () => {
        let comp: IDBTrackDetailsDeleteDialogComponent;
        let fixture: ComponentFixture<IDBTrackDetailsDeleteDialogComponent>;
        let service: IDBTrackDetailsService;
        let mockEventManager: MockEventManager;
        let mockActiveModal: MockActiveModal;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HomeApplicationTestModule],
                declarations: [IDBTrackDetailsDeleteDialogComponent],
            })
                .overrideTemplate(IDBTrackDetailsDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(IDBTrackDetailsDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(IDBTrackDetailsService);
            mockEventManager = TestBed.get(JhiEventManager);
            mockActiveModal = TestBed.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.closeSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));

            it('Should not call delete service on clear', () => {
                // GIVEN
                spyOn(service, 'delete');

                // WHEN
                comp.cancel();

                // THEN
                expect(service.delete).not.toHaveBeenCalled();
                expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
            });
        });
    });
});
