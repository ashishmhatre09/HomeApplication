import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { IDBCompanyDetailsService } from 'app/entities/idb-company-details/idb-company-details.service';
import { IIDBCompanyDetails, IDBCompanyDetails } from 'app/shared/model/idb-company-details.model';

describe('Service Tests', () => {
    describe('IDBCompanyDetails Service', () => {
        let injector: TestBed;
        let service: IDBCompanyDetailsService;
        let httpMock: HttpTestingController;
        let elemDefault: IIDBCompanyDetails;
        let expectedResult: IIDBCompanyDetails | IIDBCompanyDetails[] | boolean | null;
        let currentDate: moment.Moment;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HttpClientTestingModule],
            });
            expectedResult = null;
            injector = getTestBed();
            service = injector.get(IDBCompanyDetailsService);
            httpMock = injector.get(HttpTestingController);
            currentDate = moment();

            elemDefault = new IDBCompanyDetails(
                0,
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                currentDate,
                currentDate,
                currentDate,
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                currentDate
            );
        });

        describe('Service methods', () => {
            it('should find an element', () => {
                const returnedFromService = Object.assign(
                    {
                        meetingDate: currentDate.format(DATE_TIME_FORMAT),
                        prDate: currentDate.format(DATE_TIME_FORMAT),
                        crrDate: currentDate.format(DATE_TIME_FORMAT),
                        createdOn: currentDate.format(DATE_TIME_FORMAT),
                    },
                    elemDefault
                );

                service.find(123).subscribe(resp => (expectedResult = resp.body));

                const req = httpMock.expectOne({ method: 'GET' });
                req.flush(returnedFromService);
                expect(expectedResult).toMatchObject(elemDefault);
            });

            it('should create a IDBCompanyDetails', () => {
                const returnedFromService = Object.assign(
                    {
                        id: 0,
                        meetingDate: currentDate.format(DATE_TIME_FORMAT),
                        prDate: currentDate.format(DATE_TIME_FORMAT),
                        crrDate: currentDate.format(DATE_TIME_FORMAT),
                        createdOn: currentDate.format(DATE_TIME_FORMAT),
                    },
                    elemDefault
                );

                const expected = Object.assign(
                    {
                        meetingDate: currentDate,
                        prDate: currentDate,
                        crrDate: currentDate,
                        createdOn: currentDate,
                    },
                    returnedFromService
                );

                service.create(new IDBCompanyDetails()).subscribe(resp => (expectedResult = resp.body));

                const req = httpMock.expectOne({ method: 'POST' });
                req.flush(returnedFromService);
                expect(expectedResult).toMatchObject(expected);
            });

            it('should update a IDBCompanyDetails', () => {
                const returnedFromService = Object.assign(
                    {
                        companyCode: 'BBBBBB',
                        companyName: 'BBBBBB',
                        meetingNumber: 'BBBBBB',
                        meetingDate: currentDate.format(DATE_TIME_FORMAT),
                        prDate: currentDate.format(DATE_TIME_FORMAT),
                        crrDate: currentDate.format(DATE_TIME_FORMAT),
                        osLtRating: 'BBBBBB',
                        osStRating: 'BBBBBB',
                        osOutlook: 'BBBBBB',
                        osOtherRating: 'BBBBBB',
                        assignedLtRating: 'BBBBBB',
                        assignedStRating: 'BBBBBB',
                        assignedOutlook: 'BBBBBB',
                        assignedOtherRating: 'BBBBBB',
                        companyClassification: 'BBBBBB',
                        osLtRtgCategory: 'BBBBBB',
                        osStRtgCategory: 'BBBBBB',
                        executingDepartment: 'BBBBBB',
                        createdOn: currentDate.format(DATE_TIME_FORMAT),
                    },
                    elemDefault
                );

                const expected = Object.assign(
                    {
                        meetingDate: currentDate,
                        prDate: currentDate,
                        crrDate: currentDate,
                        createdOn: currentDate,
                    },
                    returnedFromService
                );

                service.update(expected).subscribe(resp => (expectedResult = resp.body));

                const req = httpMock.expectOne({ method: 'PUT' });
                req.flush(returnedFromService);
                expect(expectedResult).toMatchObject(expected);
            });

            it('should return a list of IDBCompanyDetails', () => {
                const returnedFromService = Object.assign(
                    {
                        companyCode: 'BBBBBB',
                        companyName: 'BBBBBB',
                        meetingNumber: 'BBBBBB',
                        meetingDate: currentDate.format(DATE_TIME_FORMAT),
                        prDate: currentDate.format(DATE_TIME_FORMAT),
                        crrDate: currentDate.format(DATE_TIME_FORMAT),
                        osLtRating: 'BBBBBB',
                        osStRating: 'BBBBBB',
                        osOutlook: 'BBBBBB',
                        osOtherRating: 'BBBBBB',
                        assignedLtRating: 'BBBBBB',
                        assignedStRating: 'BBBBBB',
                        assignedOutlook: 'BBBBBB',
                        assignedOtherRating: 'BBBBBB',
                        companyClassification: 'BBBBBB',
                        osLtRtgCategory: 'BBBBBB',
                        osStRtgCategory: 'BBBBBB',
                        executingDepartment: 'BBBBBB',
                        createdOn: currentDate.format(DATE_TIME_FORMAT),
                    },
                    elemDefault
                );

                const expected = Object.assign(
                    {
                        meetingDate: currentDate,
                        prDate: currentDate,
                        crrDate: currentDate,
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

            it('should delete a IDBCompanyDetails', () => {
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
