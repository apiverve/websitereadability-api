declare module '@apiverve/websitereadability' {
  export interface websitereadabilityOptions {
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

  export interface websitereadabilityResponse {
    status: string;
    error: string | null;
    data: WebsiteReadabilityData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface WebsiteReadabilityData {
      fleschReadingEase:             number | null;
      fleschReadingEaseText:         null | string;
      fleschKincaidGrade:            number | null;
      gunningFog:                    number | null;
      colemanLiauIndex:              number | null;
      smogIndex:                     number | null;
      automatedReadabilityIndex:     number | null;
      daleChallReadabilityScore:     number | null;
      daleChallReadabilityScoreText: null | string;
      wordCount:                     number | null;
      sentenceCount:                 number | null;
      readingTimeMinutes:            number | null;
      averageGradeLevel:             number | null;
      targetAudience:                null | string;
      url:                           null | string;
  }

  export default class websitereadabilityWrapper {
    constructor(options: websitereadabilityOptions);

    execute(callback: (error: any, data: websitereadabilityResponse | null) => void): Promise<websitereadabilityResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: websitereadabilityResponse | null) => void): Promise<websitereadabilityResponse>;
    execute(query?: Record<string, any>): Promise<websitereadabilityResponse>;
  }
}
