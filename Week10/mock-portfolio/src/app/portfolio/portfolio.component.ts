import { Component } from '@angular/core';

@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.css']
})
export class PortfolioComponent {
  projects = [
    {
      title: 'Project 1',
      description: 'This is a mock project description.',
      technologies: ['Angular', 'HTML', 'CSS'],
      image: 'bread.png'
    },
    {
      title: 'Project 2',
      description: 'This is another mock project description.',
      technologies: ['React', 'JavaScript', 'SCSS'],
      image: 'bread.png'
    },
    {
      title: 'Project 3',
      description: 'This is a third mock project description.',
      technologies: ['Vue', 'TypeScript', 'Tailwind CSS'],
      image: 'me4.png'
    }
  ];
}
