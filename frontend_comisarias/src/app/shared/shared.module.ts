import {ErrorModalComponent} from "./components/error-modal/error-modal.component";
import {CommonModule} from "@angular/common";
import {NgModule} from "@angular/core";
import { StepperComponent } from './components/stepper/stepper.component';

@NgModule({
  declarations: [
    ErrorModalComponent,
    StepperComponent
  ],
  imports: [
    CommonModule
  ],
    exports: [
        ErrorModalComponent,
        StepperComponent
    ]
})
export class SharedModule { }
