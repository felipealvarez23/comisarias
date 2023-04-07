import { NgModule } from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';
import {SkeletonComponent} from "./layout/skeleton/skeleton.component";

const routes: Routes = [
  {
    path: '',
    component: SkeletonComponent,
    children: [
      {
        path: 'medida-de-proteccion',
        loadChildren: () => import('./ui/protection-measure/protection-measure.module').then(m => m.ProtectionMeasureModule)
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    preloadingStrategy: PreloadAllModules
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
