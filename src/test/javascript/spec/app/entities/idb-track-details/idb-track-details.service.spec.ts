import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { IDBTrackDetailsService } from 'app/entities/idb-track-details/idb-track-details.service';
import { IIDBTrackDetails, IDBTrackDetails } from 'app/shared/model/idb-track-details.model';

describe('Service Tests', () => {
    describe('IDBTrackDetails Service', () => {
        let injector: TestBed;
        let service: IDBTrackDetailsService;
        let httpMock: HttpTestingController;
        let elemDefault: IIDBTrackDetails;
        let expectedResult: IIDBTrackDetails | IIDBTrackDetails[] | boolean | null;
        let currentDate: moment.Moment;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HttpClientTestingModule],
            });
            expectedResult = null;
            injector = getTestBed();
            service = injector.get(IDBTrackDetailsService);
            httpMock = injector.get(HttpTestingController);
            currentDate = moment();

            elemDefault = new IDBTrackDetails(
                0,
                'AAAAAAA',
                0,
                0,
                0,
                'AAAAAAA',
                'AAAAAAA',
                0,
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                0,
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                currentDate,
                currentDate,
                'AAAAAAA',
                'AAAAAAA'
            );
        });

        describe('Service methods', () => {
            it('should find an element', () => {
                const returnedFromService = Object.assign(
                    {
                        targetDate: currentDate.format(DATE_TIME_FORMAT),
                        createdOn: currentDate.format(DATE_TIME_FORMAT),
                    },
                    elemDefault
                );

                service.find(123).subscribe(resp => (expectedResult = resp.body));

                const req = httpMock.expectOne({ method: 'GET' });
                req.flush(returnedFromService);
                expect(expectedResult).toMatchObject(elemDefault);
            });

            it('should create a IDBTrackDetails', () => {
                const returnedFromService = Object.assign(
                    {
                        id: 0,
                        targetDate: currentDate.format(DATE_TIME_FORMAT),
                        createdOn: currentDate.format(DATE_TIME_FORMAT),
                    },
                    elemDefault
                );

                const expected = Object.assign(
                    {
                        targetDate: currentDate,
                        createdOn: currentDate,
                    },
                    returnedFromService
                );

                service.create(new IDBTrackDetails()).subscribe(resp => (expectedResult = resp.body));

                const req = httpMock.expectOne({ method: 'POST' });
                req.flush(returnedFromService);
                expect(expectedResult).toMatchObject(expected);
            });

            it('should update a IDBTrackDetails', () => {
                const returnedFromService = Object.assign(
                    {
                        companyCode: 'BBBBBB',
                        assignmentId: 1,
                        trackId: 1,
                        numberOfDays: 1,
                        employeeId: 'BBBBBB',
                        employeeName: 'BBBBBB',
                        levelId: 1,
                        listed: 'BBBBBB',
                        withdrawalOption: 'BBBBBB',
                        assigneLtRating: 'BBBBBB',
                        assigneStRating: 'BBBBBB',
                        assignedOutlook: 'BBBBBB',
                        assignedOtherRating: 'BBBBBB',
                        totalNumberofDays: 1,
                        companyClassification: 'BBBBBB',
                        reason: 'BBBBBB',
                        comments: 'BBBBBB',
                        targetDate: currentDate.format(DATE_TIME_FORMAT),
                        createdOn: currentDate.format(DATE_TIME_FORMAT),
                        executingDepartment: 'BBBBBB',
                        companyName: 'BBBBBB',
                    },
                    elemDefault
                );

                const expected = Object.assign(
                    {
                        targetDate: currentDate,
                        createdOn: currentDate,
                    },
                    returnedFromService
                );

                service.update(expected).subscribe(resp => (expectedResult = resp.body));

                const req = httpMock.expectOne({ method: 'PUT' });
                req.flush(returnedFromService);
                expect(expectedResult).toMatchObject(expected);
            });

            it('should return a list of IDBTrackDetails', () => {
                const returnedFromService = Object.assign(
                    {
                        companyCode: 'BBBBBB',
                        assignmentId: 1,
                        trackId: 1,
                        numberOfDays: 1,
                        employeeId: 'BBBBBB',
                        employeeName: 'BBBBBB',
                        levelId: 1,
                        listed: 'BBBBBB',
                        withdrawalOption: 'BBBBBB',
                        assigneLtRating: 'BBBBBB',
                        assigneStRating: 'BBBBBB',
                        assignedOutlook: 'BBBBBB',
                        assignedOtherRating: 'BBBBBB',
                        totalNumberofDays: 1,
                        companyClassification: 'BBBBBB',
                        reason: 'BBBBBB',
                        comments: 'BBBBBB',
                        targetDate: currentDate.format(DATE_TIME_FORMAT),
                        createdOn: currentDate.format(DATE_TIME_FORMAT),
                        executingDepartment: 'BBBBBB',
                        companyName: 'BBBBBB',
                    },
                    elemDefault
                );

                const expected = Object.assign(
                    {
                        targetDate: currentDate,
                        createdOn: currentDate,
                    },
                    returnedFromService
                );

                service.query().subscribe(resp => (expectedResult = resp.body));

                const req = httpMock.expectOne({ method: 'GET' });
                req.flush([returnedFromService]);
                httpMock.verify();
                expect(expectedResult).toContainEqual(expected);
            });

            it('should delete a IDBTrackDetails', () => {
                service.delete(123).subscribe(resp => (expectedResult = resp.ok));

                const req = httpMock.expectOne({ method: 'DELETE' });
                req.flush({ status: 200 });
                expect(expectedResult);
            });
        });

        afterEach(() => {
            httpMock.verify();
        });
    });
});
