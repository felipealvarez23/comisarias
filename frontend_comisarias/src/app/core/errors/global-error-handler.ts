import {ErrorHandler, Injectable, NgZone} from "@angular/core";
import {HttpErrorResponse} from "@angular/common/http";
import {ErrorModalService} from "../services/error-modal/error-modal.service";
import {ErrorModal} from "../model/interface/error-modal.interface";

@Injectable({
  providedIn: 'root'
})
export class GlobalErrorHandler implements ErrorHandler {

  constructor(private zone: NgZone, private errorModalService: ErrorModalService) {
  }


  handleError(error: any): void {
    if (error instanceof HttpErrorResponse) {
      this.zone.run(() => {
        this.errorModalService.emitFailCode(this.buildErrorModal(error));
      });
    }
  }

  buildErrorModal(httpError: HttpErrorResponse): ErrorModal{
    if(httpError.error.error) {
      return {
        errorCode: httpError.error.error.errorCode,
        errorDescription: httpError.error.errorDescription
      }
    } else {
      return {
        title: 'Tenemos problemas tecnicos',
        errorCode: 'MP001',
        errorDescription: 'Para continuar con su proceso de solicitud por favor comuníquese a la linea telefonica 31015894525 ' +
          'o escribranos al correo electronico comisarias@hotmail.com'
      };
    }
  }

}
