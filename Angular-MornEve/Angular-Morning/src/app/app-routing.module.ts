import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [];

// export const routes: Routes = [
//   { path: comp1, component: Comp1Component },
//   { path: comp2, component: Comp2Component }
// ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
