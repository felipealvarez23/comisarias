import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {ErrorModal} from "../../model/interface/error-modal.interface";

@Injectable({
  providedIn: 'root'
})
export class ErrorModalService {
  // @ts-ignore
  private toggleModalEvent = new BehaviorSubject<ErrorModal>(null);

  emitFailCode(failModal: ErrorModal): void {
    this.toggleModalEvent.next(failModal);
  }

  failListener(): Observable<ErrorModal> {
    return this.toggleModalEvent.asObservable();
  }
}
