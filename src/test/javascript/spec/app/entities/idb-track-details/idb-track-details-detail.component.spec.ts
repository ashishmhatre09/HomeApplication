import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { HomeApplicationTestModule } from '../../../test.module';
import { IDBTrackDetailsDetailComponent } from 'app/entities/idb-track-details/idb-track-details-detail.component';
import { IDBTrackDetails } from 'app/shared/model/idb-track-details.model';

describe('Component Tests', () => {
    describe('IDBTrackDetails Management Detail Component', () => {
        let comp: IDBTrackDetailsDetailComponent;
        let fixture: ComponentFixture<IDBTrackDetailsDetailComponent>;
        const route = ({ data: of({ iDBTrackDetails: new IDBTrackDetails(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HomeApplicationTestModule],
                declarations: [IDBTrackDetailsDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }],
            })
                .overrideTemplate(IDBTrackDetailsDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(IDBTrackDetailsDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should load iDBTrackDetails on init', () => {
                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.iDBTrackDetails).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
