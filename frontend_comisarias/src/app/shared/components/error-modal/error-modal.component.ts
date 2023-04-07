import {Component, OnInit} from '@angular/core';
import {ErrorModalService} from "../../../core/services/error-modal/error-modal.service";
import {filter} from "rxjs";
import {ErrorModal} from "../../../core/model/interface/error-modal.interface";

declare var window: any;

@Component({
  selector: 'app-error-modal',
  templateUrl: './error-modal.component.html',
  styleUrls: ['./error-modal.component.css']
})
export class ErrorModalComponent implements OnInit {

  title: string | undefined;
  code: string | undefined;
  description: string | undefined;
  modal: any;

  constructor(private errorModalService: ErrorModalService) {}

  ngOnInit(): void {
    this.modal = new window.bootstrap.Modal(
      document.getElementById("errorModal")
    );
    this.errorModalService.failListener()
      .pipe(filter(response => response != null ))
      .subscribe(error => {
        this.setValues(error);
        this.openModal();
      });
  }

  setValues(error: ErrorModal){
    this.title = error.title;
    this.code = error.errorCode;
    this.description = error.errorDescription;
  }

  openModal(): void {
    this.modal.show();
  }

  closeModal(): void {
    this.modal.hide();
  }

}
