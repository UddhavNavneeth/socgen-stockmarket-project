import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminIpoDetailsComponent } from './admin-ipo-details.component';

describe('AdminIpoDetailsComponent', () => {
  let component: AdminIpoDetailsComponent;
  let fixture: ComponentFixture<AdminIpoDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminIpoDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminIpoDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
