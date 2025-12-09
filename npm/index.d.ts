declare module '@apiverve/websitereadability' {
  export interface websitereadabilityOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface websitereadabilityResponse {
    status: string;
    error: string | null;
    data: WebsiteReadabilityData;
    code?: number;
  }


  interface WebsiteReadabilityData {
      fleschReadingEase:             number;
      fleschReadingEaseText:         string;
      fleschKincaidGrade:            number;
      gunningFog:                    number;
      colemanLiauIndex:              number;
      smogIndex:                     number;
      automatedReadabilityIndex:     number;
      daleChallReadabilityScore:     number;
      daleChallReadabilityScoreText: string;
      url:                           string;
  }

  export default class websitereadabilityWrapper {
    constructor(options: websitereadabilityOptions);

    execute(callback: (error: any, data: websitereadabilityResponse | null) => void): Promise<websitereadabilityResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: websitereadabilityResponse | null) => void): Promise<websitereadabilityResponse>;
    execute(query?: Record<string, any>): Promise<websitereadabilityResponse>;
  }
}
