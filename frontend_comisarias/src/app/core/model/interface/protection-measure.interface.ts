export interface PMPayload {
  data: PMDataPayload;
}

export interface PMDataPayload {
  type: string;
  documentType: string;
  documentNumber: string;
}

export interface PMResponse {
  data: PMDataResponse;
}

export interface  PMDataResponse {
  protectionMeasureId: string;
  nextStepUrl: string;
  type: string;
}
