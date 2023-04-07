import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PMPayload, PMResponse} from "../../../model/interface/protection-measure.interface";

@Injectable({
  providedIn: 'root'
})
export class ProtectionMeasureService {

  url = "http://localhost:8082/comisarias/api/v1/";

  constructor(private httpClient: HttpClient) { }

  startRequest(payload: PMPayload): Observable<PMResponse>{
    return this.httpClient.post<PMResponse>(this.url + 'start-request', payload);
  }

}
