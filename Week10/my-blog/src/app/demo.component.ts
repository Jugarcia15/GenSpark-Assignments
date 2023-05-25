import { Component } from "@angular/core";

@Component (
    {
      selector: 'demo-comp',
      template: `
      <h1> This is my manual created Component !! </h1>
      <h1> Hello {{name}} </h1>
      `
    }
)

export class demoComponent{
    name="Genspark";
}
