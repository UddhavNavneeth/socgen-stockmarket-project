import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminIpoListComponent } from './admin-ipo-list.component';

describe('AdminIpoListComponent', () => {
  let component: AdminIpoListComponent;
  let fixture: ComponentFixture<AdminIpoListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminIpoListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminIpoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
