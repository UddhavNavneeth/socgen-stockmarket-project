import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyListBySectorComponent } from './company-list-by-sector.component';

describe('CompanyListBySectorComponent', () => {
  let component: CompanyListBySectorComponent;
  let fixture: ComponentFixture<CompanyListBySectorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompanyListBySectorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CompanyListBySectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
