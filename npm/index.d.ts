declare module '@apiverve/moonrisemoonset' {
  export interface moonrisemoonsetOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface moonrisemoonsetResponse {
    status: string;
    error: string | null;
    data: MoonriseMoonsetData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface MoonriseMoonsetData {
      coordinates:    Coordinates;
      phase:          null | string;
      moonrise:       Date | null;
      moonset:        Date | null;
      moonAlwaysUp:   boolean | null;
      moonAlwaysDown: boolean | null;
  }
  
  interface Coordinates {
      latitude:  number | null;
      longitude: number | null;
  }

  export default class moonrisemoonsetWrapper {
    constructor(options: moonrisemoonsetOptions);

    execute(callback: (error: any, data: moonrisemoonsetResponse | null) => void): Promise<moonrisemoonsetResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: moonrisemoonsetResponse | null) => void): Promise<moonrisemoonsetResponse>;
    execute(query?: Record<string, any>): Promise<moonrisemoonsetResponse>;
  }
}
