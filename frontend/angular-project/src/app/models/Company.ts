import { Sector } from '../models/Sector';

export interface Company {
    id?: number,
    name: string,
    turnover: number,
    ceo: string,
    brief: string,
    sector: Sector
}