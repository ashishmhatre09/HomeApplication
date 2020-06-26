import { Moment } from 'moment';

export interface IIDBTrackDetails {
    id?: number;
    companyCode?: string;
    assignmentId?: number;
    trackId?: number;
    numberOfDays?: number;
    employeeId?: string;
    employeeName?: string;
    levelId?: number;
    listed?: string;
    withdrawalOption?: string;
    assigneLtRating?: string;
    assigneStRating?: string;
    assignedOutlook?: string;
    assignedOtherRating?: string;
    totalNumberofDays?: number;
    companyClassification?: string;
    reason?: string;
    comments?: string;
    targetDate?: Moment;
    createdOn?: Moment;
    executingDepartment?: string;
    companyName?: string;
}

export class IDBTrackDetails implements IIDBTrackDetails {
    constructor(
        public id?: number,
        public companyCode?: string,
        public assignmentId?: number,
        public trackId?: number,
        public numberOfDays?: number,
        public employeeId?: string,
        public employeeName?: string,
        public levelId?: number,
        public listed?: string,
        public withdrawalOption?: string,
        public assigneLtRating?: string,
        public assigneStRating?: string,
        public assignedOutlook?: string,
        public assignedOtherRating?: string,
        public totalNumberofDays?: number,
        public companyClassification?: string,
        public reason?: string,
        public comments?: string,
        public targetDate?: Moment,
        public createdOn?: Moment,
        public executingDepartment?: string,
        public companyName?: string
    ) {}
}
