declare module '@apiverve/moonrisemoonset' {
  export interface moonrisemoonsetOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface moonrisemoonsetResponse {
    status: string;
    error: string | null;
    data: MoonriseMoonsetData;
    code?: number;
  }


  interface MoonriseMoonsetData {
      coordinates:    Coordinates;
      phase:          string;
      moonrise:       Date;
      moonset:        Date;
      moonAlwaysUp:   boolean;
      moonAlwaysDown: boolean;
  }
  
  interface Coordinates {
      latitude:  number;
      longitude: number;
  }

  export default class moonrisemoonsetWrapper {
    constructor(options: moonrisemoonsetOptions);

    execute(callback: (error: any, data: moonrisemoonsetResponse | null) => void): Promise<moonrisemoonsetResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: moonrisemoonsetResponse | null) => void): Promise<moonrisemoonsetResponse>;
    execute(query?: Record<string, any>): Promise<moonrisemoonsetResponse>;
  }
}
