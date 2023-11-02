export class BaseAppConstants {
	public static isMobile = window.matchMedia('only screen and (max-width: 760px)').matches;
	
	public static dateFormat = 'dd-MMM-yyyy';
	public static dateTimeFormat = 'dd-MMM-yyyy hh:mm aa';
	public static calDateFormat = 'dd-mm-y';
	public static defaultLocale = getLocale();
	public static defaultCurrency = 'EUR';
	public static defaultPageSize = 50;
	public static attachmentBaseURL = 'rest/attachments/download/attachment/';
	public static enableReadOnly = false;
	public static localFilePath = '/assets/images/';
	public static showScrollSpy = false;
	public static showBreadcrumb = false;
	public static selectFirstMenuByDefault = false;
	public static showPaginationonTop = true;
	public static showPaginationonBottom = false;
	public static isSql = false;
	public static dateFormatAngular = 'd/M/y';
	public static dateTimeFormatAngular = 'd/M/y h:mm:ss a z';
	public static timeFormatAngular = 'h:mm:ss a z';
	public static dateFormatPrimeNG = 'd/M/yy';
	public static dateTimeFormatPrimeNG = 'd/M/yy h:mm:ss a z';
	public static timeFormatPrimeNG = 'h:mm:ss a z';
	public static currency = 'EUR';
	public static currencyDisplay = 'Symbol';
	public static numberFormat = { "displayValue": "9.999,00", "thousandSeparator": ",", "decimalSeperator": "." };
	public static minInteger = 0;
	public static minFraction = 0;
	public static maxFraction = 0;

}

function getLocale(): string {
	const browserLang: string = window?.navigator?.language
	// (en|de|fr|ru|tr|it|pl|uk|nl|ja|ko|zh) // English,German,French,Russian,Turkish,Italian,Polish,Ukrainian,Dutch,Japanese,Korean,Chinese
	const supportingLanguages: string[] = ['en-US', 'de-DE', 'fr-FR', 'ru-RU', 'tr-TR', 'it-IT', 'pl-PL', 'uk-UA', 'nl-NL', 'ja-JP', 'ko-KR', 'zh-CN']
	if (browserLang) {
		if (supportingLanguages.includes(browserLang)) {
			return browserLang;
		} else {
			return 'en-US'
		}
	} else {
		return 'en-US'
	}
}