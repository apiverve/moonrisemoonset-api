/// Response models for the Moonrise Moonset API.

/// API Response wrapper.
class MoonrisemoonsetResponse {
  final String status;
  final dynamic error;
  final MoonrisemoonsetData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  MoonrisemoonsetResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory MoonrisemoonsetResponse.fromJson(Map<String, dynamic> json) => MoonrisemoonsetResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? MoonrisemoonsetData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Moonrise Moonset API.

class MoonrisemoonsetData {
  MoonrisemoonsetDataCoordinates? coordinates;
  String? phase;
  String? moonrise;
  String? moonset;
  bool? moonAlwaysUp;
  bool? moonAlwaysDown;

  MoonrisemoonsetData({
    this.coordinates,
    this.phase,
    this.moonrise,
    this.moonset,
    this.moonAlwaysUp,
    this.moonAlwaysDown,
  });

  factory MoonrisemoonsetData.fromJson(Map<String, dynamic> json) => MoonrisemoonsetData(
      coordinates: json['coordinates'] != null ? MoonrisemoonsetDataCoordinates.fromJson(json['coordinates']) : null,
      phase: json['phase'],
      moonrise: json['moonrise'],
      moonset: json['moonset'],
      moonAlwaysUp: json['moonAlwaysUp'],
      moonAlwaysDown: json['moonAlwaysDown'],
    );
}

class MoonrisemoonsetDataCoordinates {
  num? latitude;
  num? longitude;

  MoonrisemoonsetDataCoordinates({
    this.latitude,
    this.longitude,
  });

  factory MoonrisemoonsetDataCoordinates.fromJson(Map<String, dynamic> json) => MoonrisemoonsetDataCoordinates(
      latitude: json['latitude'],
      longitude: json['longitude'],
    );
}

class MoonrisemoonsetRequest {
  double lat;
  double lon;
  String? date;

  MoonrisemoonsetRequest({
    required this.lat,
    required this.lon,
    this.date,
  });

  Map<String, dynamic> toJson() => {
      'lat': lat,
      'lon': lon,
      if (date != null) 'date': date,
    };
}
