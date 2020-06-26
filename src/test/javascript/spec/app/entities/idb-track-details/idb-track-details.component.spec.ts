import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { HomeApplicationTestModule } from '../../../test.module';
import { IDBTrackDetailsComponent } from 'app/entities/idb-track-details/idb-track-details.component';
import { IDBTrackDetailsService } from 'app/entities/idb-track-details/idb-track-details.service';
import { IDBTrackDetails } from 'app/shared/model/idb-track-details.model';

describe('Component Tests', () => {
    describe('IDBTrackDetails Management Component', () => {
        let comp: IDBTrackDetailsComponent;
        let fixture: ComponentFixture<IDBTrackDetailsComponent>;
        let service: IDBTrackDetailsService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HomeApplicationTestModule],
                declarations: [IDBTrackDetailsComponent],
            })
                .overrideTemplate(IDBTrackDetailsComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(IDBTrackDetailsComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(IDBTrackDetailsService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new IDBTrackDetails(123)],
                        headers,
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.iDBTrackDetails && comp.iDBTrackDetails[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
