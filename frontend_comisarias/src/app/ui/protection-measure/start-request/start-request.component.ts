import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ProtectionMeasureService} from "../../../core/services/api/protection-measure/protection-measure.service";
import {PMPayload} from "../../../core/model/interface/protection-measure.interface";
import {finalize} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './start-request.component.html',
  styleUrls: ['./start-request.component.css']
})
export class StartRequestComponent implements OnInit {

  startRequestForm: FormGroup;
  loadingFlag = false;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private proMeasureService: ProtectionMeasureService
  ) {
    this.startRequestForm = new FormGroup({});
  }

  ngOnInit(): void {
    this.buildStartRequestForm();
  }

  get controls(): { [key: string]: AbstractControl } {
    return this.startRequestForm.controls;
  }

  getErrorDescription(controlName: string): string {
    const errors = this.startRequestForm.get(controlName)?.errors;
    if (errors?.required) {
      return 'Campo requerido';
    } else if(errors?.pattern) {
      return 'Caracteres invalidos';
    } else if(errors?.minlength) {
      return 'La longitud minima del campo es de 4 caracteres';
    } else if(errors?.maxlength) {
      return 'La longitud maxima del campo es de 12 caracteres';
    } else {
      return '';
    }
  }

  private buildStartRequestForm() {
    this.startRequestForm = this.fb.group({
      applicantModality: ['', Validators.required],
      documentType: ['', Validators.required],
      documentNumber: ['', [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(12),
        Validators.pattern(/^[0-9]+$/)
      ]]
    });
  }

  continue() {
    this.loadingFlag = true;
    const payload = this.buildProMeasurePayload();
    this.proMeasureService.startRequest(payload)
      .pipe(finalize(() => this.loadingFlag = false))
      .subscribe(response => {
        if(response.data && response.data.nextStepUrl) {
          this.router.navigate([response.data.nextStepUrl]);
        }
      });
  }

  private buildProMeasurePayload(): PMPayload {
    return {
      data: {
        type: this.startRequestForm.get('type')?.value,
        documentNumber: this.startRequestForm.get('documentNumber')?.value,
        documentType: this.startRequestForm.get('documentType')?.value,
      }
    }
  }

}
