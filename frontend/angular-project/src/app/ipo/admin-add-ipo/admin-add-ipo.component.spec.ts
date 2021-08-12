import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddIpoComponent } from './admin-add-ipo.component';

describe('AdminAddIpoComponent', () => {
  let component: AdminAddIpoComponent;
  let fixture: ComponentFixture<AdminAddIpoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAddIpoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddIpoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
