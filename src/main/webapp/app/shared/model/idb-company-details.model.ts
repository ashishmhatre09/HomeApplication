import { Moment } from 'moment';
import { IIDBTrackDetails } from 'app/shared/model/idb-track-details.model';

export interface IIDBCompanyDetails {
    id?: number;
    companyCode?: string;
    companyName?: string;
    meetingNumber?: string;
    meetingDate?: Moment;
    prDate?: Moment;
    crrDate?: Moment;
    osLtRating?: string;
    osStRating?: string;
    osOutlook?: string;
    osOtherRating?: string;
    assignedLtRating?: string;
    assignedStRating?: string;
    assignedOutlook?: string;
    assignedOtherRating?: string;
    companyClassification?: string;
    osLtRtgCategory?: string;
    osStRtgCategory?: string;
    executingDepartment?: string;
    createdOn?: Moment;
    companyCodes?: IIDBTrackDetails[];
}

export class IDBCompanyDetails implements IIDBCompanyDetails {
    constructor(
        public id?: number,
        public companyCode?: string,
        public companyName?: string,
        public meetingNumber?: string,
        public meetingDate?: Moment,
        public prDate?: Moment,
        public crrDate?: Moment,
        public osLtRating?: string,
        public osStRating?: string,
        public osOutlook?: string,
        public osOtherRating?: string,
        public assignedLtRating?: string,
        public assignedStRating?: string,
        public assignedOutlook?: string,
        public assignedOtherRating?: string,
        public companyClassification?: string,
        public osLtRtgCategory?: string,
        public osStRtgCategory?: string,
        public executingDepartment?: string,
        public createdOn?: Moment,
        public companyCodes?: IIDBTrackDetails[]
    ) {}
}
